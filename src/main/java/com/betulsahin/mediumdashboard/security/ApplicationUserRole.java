package com.betulsahin.mediumdashboard.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.betulsahin.mediumdashboard.security.ApplicationUserPermission.POST_READ;
import static com.betulsahin.mediumdashboard.security.ApplicationUserPermission.POST_WRITE;

public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(POST_READ, POST_WRITE));

    private final Set<ApplicationUserPermission> permissions;
    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}
