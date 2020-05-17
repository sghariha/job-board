package com.shariharan.jobboard.api;

import java.util.HashMap;
import java.util.List;

import com.shariharan.jobboard.auth.TokenUtil;
import com.shariharan.jobboard.db.CompanyRepository;
import com.shariharan.jobboard.error_handlers.InvalidTokenException;
import com.shariharan.jobboard.model.company.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/allMatching/{substring}")
    public ResponseEntity<HashMap<String, String>> getMatchingCompanyNames(
        @RequestHeader("Authorization") String token, 
        @PathVariable String substring
    ) {
        try {
            TokenUtil.decodeToken(token);
        }
        catch (InvalidTokenException e) {
            return ResponseEntity.status(401).body(null);
        }

        return null;
    }
}