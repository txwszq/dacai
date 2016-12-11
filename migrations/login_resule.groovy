databaseChangeLog = {

    changeSet(author: "michael (generated)", id: "1481208340303-1") {
        createTable(tableName: "login_result") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "login_resultPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "discuz_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "failed_times", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "michael (generated)", id: "1481208340303-2") {
        addForeignKeyConstraint(baseColumnNames: "discuz_id", baseTableName: "login_result", constraintName: "FK_s6p59msa5nkyf1tbp58simw4g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "discuz")
    }
}
