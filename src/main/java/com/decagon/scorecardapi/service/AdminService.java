package com.decagon.scorecardapi.service;

import com.decagon.scorecardapi.response.AdminResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {
    List<AdminResponse> getAllAdmin();
}
