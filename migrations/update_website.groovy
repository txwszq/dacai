databaseChangeLog = {

    changeSet(author: "michael (generated)", id: "1481208448818-2") {
        addColumn(tableName: "discuz") {
            column(name: "account_status", type: "integer") {
                constraints(nullable: "false")
            }
        }
    }
}
