package com.hoangbui.shopping.service;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
    void send(String emailTo, String subject, String message);
}
