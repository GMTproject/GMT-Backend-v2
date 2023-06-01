package com.pmn.gmt.domain.teacher.domain.dao;


import com.pmn.gmt.domain.teacher.domain.dto.responseDto.DaoTeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

@Repository
public class TeacherDaoImpl implements TeacherDao{

    @Autowired
    private DataSource dataSource;



    public LinkedList<DaoTeacherDTO> getUserInfo() throws SQLException {
        LinkedList<DaoTeacherDTO> daoTeacherDTOS = new LinkedList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement("select *from teachers");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DaoTeacherDTO daoTeacherDTO = new DaoTeacherDTO();
                daoTeacherDTO.setName(rs.getString("name"));
                daoTeacherDTO.setContact((rs.getString("contact")));
                daoTeacherDTOS.add(daoTeacherDTO);
            }
        }
        finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
        return daoTeacherDTOS;
    }
}
