package com.makliftsan.visibility.service;

import com.makliftsan.visibility.entity.*;
import com.makliftsan.visibility.repository.MachineOrderRepository;
import com.makliftsan.visibility.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MachineOrderService {

    private final MachineOrderRepository machineOrderRepository;
    private final UserRepository userRepository;

    public List<MachineOrder> getVisibleOrdersForUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));

        Set<RoleName> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        if (roles.contains(RoleName.ROLE_ADMIN)
                || roles.contains(RoleName.ROLE_MANAGER)
                || roles.contains(RoleName.ROLE_IT)
                || roles.contains(RoleName.ROLE_IMPORT_EXPORT)) {
            return machineOrderRepository.findAll();
        }

        return machineOrderRepository.findByVisibilityType(VisibilityType.PUBLIC);
    }

    public MachineOrder save(MachineOrder machineOrder, String username) {
        machineOrder.setCreatedBy(username);
        return machineOrderRepository.save(machineOrder);
    }

    public MachineOrder createEmptyOrder() {
        MachineOrder order = new MachineOrder();
        order.setVisibilityType(VisibilityType.PUBLIC);
        return order;
    }
}