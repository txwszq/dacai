databaseChangeLog = {

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475897424672-1") {
        createTable(tableName: "t_login") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "t_loginPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "s_login_url", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475897424672-2") {
        createTable(tableName: "t_login_params") {
            column(name: "login_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "params_string", type: "VARCHAR(255)")

            column(name: "params_idx", type: "VARCHAR(255)")

            column(name: "params_elt", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475897424672-3") {
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

            column(name: "s_topic_url", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "web_site_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "topics_idx", type: "INT")
        }
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475897424672-4") {
        createTable(tableName: "t_topic_params") {
            column(name: "topic_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "params_string", type: "VARCHAR(255)")

            column(name: "params_idx", type: "VARCHAR(255)")

            column(name: "params_elt", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475897424672-5") {
        createTable(tableName: "t_web_site") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "t_web_sitePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "n_login_id", type: "BIGINT") {
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

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475897424672-6") {
        addForeignKeyConstraint(baseColumnNames: "web_site_id", baseTableName: "t_topic", constraintName: "FK_mir2ncu4bxp43b9dfmkn9tpg6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_web_site")
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "1475897424672-7") {
        addForeignKeyConstraint(baseColumnNames: "n_login_id", baseTableName: "t_web_site", constraintName: "FK_nbd96frlsm6ogqmrv9q07yf4u", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "t_login")
    }
}
