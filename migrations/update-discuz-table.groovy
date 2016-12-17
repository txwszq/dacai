databaseChangeLog = {

    changeSet(author: "michael (generated)", id: "1481985642107-1") {
        addColumn(tableName: "discuz") {
            column(defaultValue: "1", defaultValueNumeric: "1", name: "leave_msg_status", type: "integer") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "michael (generated)", id: "1481985642107-2") {
        addColumn(tableName: "discuz") {
            column(defaultValue: "1", defaultValueNumeric: "1", name: "send_msg_status", type: "integer") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "michael (generated)", id: "1481985642107-3") {
        addColumn(tableName: "discuz") {
            column(defaultValue: "1", defaultValueNumeric: "1", name: "shouting_status", type: "integer") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "zhiqiang.zhao (generated)", id: "update-shouting") {
        grailsChange {
            change {
                sql.execute("update discuz set shouting_Status = 2 where id = 9")
            }
        }
    }
}
