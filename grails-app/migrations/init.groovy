databaseChangeLog = {

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475054779335-1") {
        createTable(tableName: "t_role") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "t_rolePK")
            }

            column(name: "s_authority", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475054779335-2") {
        createTable(tableName: "t_user") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "t_userPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "is_account_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "is_account_locked", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "n_user_id", type: "BIGINT")

            column(name: "d_create_time", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "is_enabled", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "d_expired_date", type: "datetime")

            column(name: "s_fullname", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "d_last_login_ip", type: "VARCHAR(255)")

            column(name: "d_last_login_time", type: "datetime")

            column(name: "is_new_account", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "s_password", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "is_password_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "d_update_time", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "s_username", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475054779335-3") {
        createTable(tableName: "t_user_role") {
            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475054779335-4") {
        addPrimaryKey(columnNames: "user_id, role_id", constraintName: "t_user_rolePK", tableName: "t_user_role")
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475054779335-5") {
        addUniqueConstraint(columnNames: "s_authority", constraintName: "UC_T_ROLES_AUTHORITY_COL", tableName: "t_role")
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475054779335-6") {
        addUniqueConstraint(columnNames: "s_username", constraintName: "UC_T_USERS_USERNAME_COL", tableName: "t_user")
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475054779335-7") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "t_user_role", constraintName: "FK_4uvv76e86ms8ru0kk9s01d3s2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_role")
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475054779335-8") {
        addForeignKeyConstraint(baseColumnNames: "n_user_id", baseTableName: "t_user", constraintName: "FK_6vvkl5qia1e9dtvmt37486t0y", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_user")
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475054779335-9") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "t_user_role", constraintName: "FK_kefwen29p9h9ilvry31mgyc94", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_user")
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "init-role") {
        grailsChange {
            change {
                sql.execute("INSERT INTO t_role (id, s_authority) VALUES (1, 'ROLE_SUPER_ADMIN')")
                sql.execute("INSERT INTO t_role (id, s_authority) VALUES (2, 'ROLE_ADMIN')")
                sql.execute("INSERT INTO t_role (id, s_authority) VALUES (3, 'ROLE_VIP1')")
                sql.execute("INSERT INTO t_role (id, s_authority) VALUES (4, 'ROLE_VIP2')")
                sql.execute("INSERT INTO t_role (id, s_authority) VALUES (5, 'ROLE_VIP3')")
                sql.execute("INSERT INTO t_role (id, s_authority) VALUES (6, 'ROLE_VIP4')")
                sql.execute("INSERT INTO t_role (id, s_authority) VALUES (7, 'ROLE_NORMAL_USER')")
            }
        }
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "init-admin-account") {
        grailsChange {
            change {
                sql.execute("INSERT INTO `t_user` (`id`,`version`,`is_account_expired`,`is_account_locked`,`is_enabled`,`s_password`,`is_password_expired`,`s_username`,s_fullname,is_new_account, d_create_time, d_update_time) VALUES('1','1',FALSE,FALSE,TRUE,'a9c4119c3a2d3ec02f637618329d317c6262760e',FALSE,'admin','超级管理员', TRUE, '2016-08-18 12:00:00', '2016-08-18 12:00:00')")
                sql.execute("INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES ('1', '1')")
                sql.execute("INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES ('1', '2')")
                sql.execute("INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES ('1', '3')")
                sql.execute("INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES ('1', '4')")
                sql.execute("INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES ('1', '5')")
                sql.execute("INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES ('1', '6')")
                sql.execute("INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES ('1', '7')")
            }
        }
    }
}
