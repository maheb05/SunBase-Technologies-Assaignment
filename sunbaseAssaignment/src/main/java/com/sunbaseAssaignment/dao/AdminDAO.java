package com.sunbaseAssaignment.dao;

import com.sunbaseAssaignment.entity.AdminEntity;

// Interface defining methods for AdminEntity data access
public interface AdminDAO {

    // Method to save an AdminEntity to the database
    boolean saveAdminEntity(AdminEntity entity);
}
