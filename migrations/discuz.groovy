databaseChangeLog = {

    changeSet(author: "michael (generated)", id: "1481207530136-1") {
        createTable(tableName: "discuz") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "discuzPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "current_id", type: "INT")

            column(name: "login_type", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "max_id", type: "INT")

            column(name: "password", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "send_type", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "url", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }



}
