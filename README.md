# Machine Visibility System

Role-based machine order visibility system developed with Spring Boot.

## Features

- Role based authorization
- Machine order creation
- Visibility control for departments
- PostgreSQL database
- Docker containerized database
- Spring Security authentication

## Roles

- CEO
- BOSS
- IT
- IMPORT_EXPORT
- SALES

## Technologies

- Java
- Spring Boot
- Spring Security
- PostgreSQL
- Docker
- Thymeleaf

## Project Structure

controller -> API and web endpoints  
service -> Business logic  
repository -> Database operations  
entity -> Database models  
config -> Security and configuration  

## Purpose

This system ensures that sensitive machine orders can only be viewed by authorized departments such as management, IT, and import-export teams.

Sales department cannot see restricted orders.
