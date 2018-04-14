package com.tesseractbd.qrscanner;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by hhson on 4/14/2018.
 */

@Table(name = "User")
public class User extends Model{

    @Column (name = "userName")
    public String userName;
    @Column (name = "password")
    public String password;

    public User() {
    }
}
