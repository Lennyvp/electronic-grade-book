package com.patryk_michal.electronicgradebook.postgressConnection.admin;

import com.patryk_michal.electronicgradebook.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
