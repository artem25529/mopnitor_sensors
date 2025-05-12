package com.es.monitor_sensors.converters;

import com.es.monitor_sensors.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserConverter {
    public static UserDetails convertToUserDetails(final User user) {
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return user.getAuthorities()
                        .stream()
                        .map(authority -> (GrantedAuthority) authority::getAuthority)
                        .collect(Collectors.toSet());
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

            @Override
            public boolean isEnabled() {
                return user.isEnabled();
            }
        };
    }
}
