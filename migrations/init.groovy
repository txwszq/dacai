databaseChangeLog = {

    changeSet(author: "michael (generated)", id: "1478187982818-1") {
        createTable(tableName: "t_role") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "t_rolePK")
            }

            column(name: "s_authority", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "michael (generated)", id: "1478187982818-2") {
        createTable(tableName: "t_topic") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "t_topicPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "s_topic_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "michael (generated)", id: "1478187982818-3") {
        createTable(tableName: "t_topic_t_web_site_params") {
            column(name: "topic_site_params_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "site_params_id", type: "BIGINT")
        }
    }

    changeSet(author: "michael (generated)", id: "1478187982818-4") {
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

    changeSet(author: "michael (generated)", id: "1478187982818-5") {
        createTable(tableName: "t_user_role") {
            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "michael (generated)", id: "1478187982818-6") {
        createTable(tableName: "t_web_site") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "t_web_sitePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "code", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "s_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "s_url", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "michael (generated)", id: "1478187982818-7") {
        createTable(tableName: "t_web_site_params") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "t_web_site_paramsPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "s_code", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "s_value", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "michael (generated)", id: "1478187982818-8") {
        createTable(tableName: "t_web_site_t_topic") {
            column(name: "web_site_topics_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "topic_id", type: "BIGINT")
        }
    }

    changeSet(author: "michael (generated)", id: "1478187982818-9") {
        addPrimaryKey(columnNames: "user_id, role_id", constraintName: "t_user_rolePK", tableName: "t_user_role")
    }

    changeSet(author: "michael (generated)", id: "1478187982818-10") {
        addUniqueConstraint(columnNames: "s_authority", constraintName: "UC_T_ROLES_AUTHORITY_COL", tableName: "t_role")
    }

    changeSet(author: "michael (generated)", id: "1478187982818-11") {
        addUniqueConstraint(columnNames: "s_username", constraintName: "UC_T_USERS_USERNAME_COL", tableName: "t_user")
    }

    changeSet(author: "michael (generated)", id: "1478187982818-12") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "t_user_role", constraintName: "FK_4uvv76e86ms8ru0kk9s01d3s2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_role")
    }

    changeSet(author: "michael (generated)", id: "1478187982818-13") {
        addForeignKeyConstraint(baseColumnNames: "n_user_id", baseTableName: "t_user", constraintName: "FK_6vvkl5qia1e9dtvmt37486t0y", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_user")
    }

    changeSet(author: "michael (generated)", id: "1478187982818-14") {
        addForeignKeyConstraint(baseColumnNames: "web_site_topics_id", baseTableName: "t_web_site_t_topic", constraintName: "FK_7vv700rrjodf1kvmlaqdroumg", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_web_site")
    }

    changeSet(author: "michael (generated)", id: "1478187982818-15") {
        addForeignKeyConstraint(baseColumnNames: "topic_id", baseTableName: "t_web_site_t_topic", constraintName: "FK_8h3laibqcnyfqqn0cbhj0ws3q", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_topic")
    }

    changeSet(author: "michael (generated)", id: "1478187982818-16") {
        addForeignKeyConstraint(baseColumnNames: "topic_site_params_id", baseTableName: "t_topic_t_web_site_params", constraintName: "FK_e29pbk8hlgborgmx02kf5iyij", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_topic")
    }

    changeSet(author: "michael (generated)", id: "1478187982818-17") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "t_user_role", constraintName: "FK_kefwen29p9h9ilvry31mgyc94", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_user")
    }

    changeSet(author: "michael (generated)", id: "1478187982818-18") {
        addForeignKeyConstraint(baseColumnNames: "site_params_id", baseTableName: "t_topic_t_web_site_params", constraintName: "FK_nbj1ahalk10vnroomxh1t7jbb", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_web_site_params")
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
