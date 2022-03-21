//package com.example.coding_bat_jwt.component;
//
//import com.example.coding_bat_jwt.entity.Role;
//import com.example.coding_bat_jwt.entity.Subject;
//import com.example.coding_bat_jwt.entity.User;
//import com.example.coding_bat_jwt.entity.enums.PermissionEnum;
//import com.example.coding_bat_jwt.entity.enums.RoleEnum;
//import com.example.coding_bat_jwt.repository.RoleRepository;
//import com.example.coding_bat_jwt.repository.SubjectRepository;
//import com.example.coding_bat_jwt.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class DataLoader implements CommandLineRunner {
//
//    final RoleRepository roleRepository;
//    final UserRepository userRepository;
//    final PasswordEncoder passwordEncoder;
//    final SubjectRepository subjectRepository;
//
//    @Value("${spring.sql.init.mode}")
//    private String mode;
//    @Value("${spring.jpa.hibernate.ddl-auto}")
//    private String ddl;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (mode.equals("always") && ddl.equals("create")) {
//            Role admin = new Role();
//            admin.setName(RoleEnum.ADMIN);
//            admin.setPermissionEnumSet(Arrays.stream(PermissionEnum.values()).collect(Collectors.toSet()));
//            Role manager = new Role();
//            manager.setName(RoleEnum.MANAGER);
//            manager.setPermissionEnumSet(new HashSet<>(Arrays.asList(
//                    PermissionEnum.READ_ALL_SUBJECT,
//                    PermissionEnum.EDIT_SUBJECT,
//                    PermissionEnum.READ_SUBJECT
//            )));
//            Role user_role = new Role();
//            user_role.setName(RoleEnum.USER);
//            user_role.setPermissionEnumSet(new HashSet<>(Arrays.asList(
//                    PermissionEnum.READ_SUBJECT,
//                    PermissionEnum.READ_ALL_SUBJECT
//            )));
//            roleRepository.save(admin);
//            roleRepository.save(manager);
//            roleRepository.save(user_role);
//            Subject subject = new Subject();
//            subject.setName("Java_Advance");
//            subjectRepository.save(subject);
//
//            Set<Role> roles = new HashSet<>();
//            roles.add(admin);
//            roles.add(manager);
//            roles.add(user_role);
//
//            User user = new User("Bexruz", roles,
//                    "bekhruz", passwordEncoder.encode("0000"), true);
//            userRepository.save(user);
//        }
//
//    }
//}
