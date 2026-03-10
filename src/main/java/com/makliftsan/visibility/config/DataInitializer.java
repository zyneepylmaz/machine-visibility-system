package com.makliftsan.visibility.config;

import com.makliftsan.visibility.entity.*;
import com.makliftsan.visibility.repository.MachineOrderRepository;
import com.makliftsan.visibility.repository.RoleRepository;
import com.makliftsan.visibility.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final MachineOrderRepository machineOrderRepository;

    @Override
    public void run(String... args) {

        if (roleRepository.count() == 0) {
            Role admin = roleRepository.save(new Role(null, RoleName.ROLE_ADMIN));
            Role manager = roleRepository.save(new Role(null, RoleName.ROLE_MANAGER));
            Role it = roleRepository.save(new Role(null, RoleName.ROLE_IT));
            Role importExport = roleRepository.save(new Role(null, RoleName.ROLE_IMPORT_EXPORT));
            Role sales = roleRepository.save(new Role(null, RoleName.ROLE_SALES));

            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword("1234");
            adminUser.setFullName("Admin User");
            adminUser.setEnabled(true);
            adminUser.setRoles(new HashSet<>(Set.of(admin)));
            userRepository.save(adminUser);

            User managerUser = new User();
            managerUser.setUsername("manager");
            managerUser.setPassword("1234");
            managerUser.setFullName("Manager User");
            managerUser.setEnabled(true);
            managerUser.setRoles(new HashSet<>(Set.of(manager)));
            userRepository.save(managerUser);

            User itUser = new User();
            itUser.setUsername("it");
            itUser.setPassword("1234");
            itUser.setFullName("IT User");
            itUser.setEnabled(true);
            itUser.setRoles(new HashSet<>(Set.of(it)));
            userRepository.save(itUser);

            User importExportUser = new User();
            importExportUser.setUsername("importexport");
            importExportUser.setPassword("1234");
            importExportUser.setFullName("Import Export User");
            importExportUser.setEnabled(true);
            importExportUser.setRoles(new HashSet<>(Set.of(importExport)));
            userRepository.save(importExportUser);

            User salesUser = new User();
            salesUser.setUsername("sales");
            salesUser.setPassword("1234");
            salesUser.setFullName("Sales User");
            salesUser.setEnabled(true);
            salesUser.setRoles(new HashSet<>(Set.of(sales)));
            userRepository.save(salesUser);
        }

        if (machineOrderRepository.count() == 0) {
            MachineOrder order1 = new MachineOrder();
            order1.setOrderCode("ORD-1001");
            order1.setMachineName("HNC6061");
            order1.setOwnerName("Makliftsan Demo Customer");
            order1.setSaleType("SALE");
            order1.setVisibilityType(VisibilityType.MANAGEMENT_ONLY);
            order1.setCreatedBy("admin");
            machineOrderRepository.save(order1);

            MachineOrder order2 = new MachineOrder();
            order2.setOrderCode("ORD-1002");
            order2.setMachineName("CPCD30");
            order2.setOwnerName("Public Demo Customer");
            order2.setSaleType("RENTAL");
            order2.setVisibilityType(VisibilityType.PUBLIC);
            order2.setCreatedBy("admin");
            machineOrderRepository.save(order2);
        }
    }
}