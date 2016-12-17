databaseChangeLog = {

    changeSet(author: "michael (generated)", id: "1481208448818-2") {
        addColumn(tableName: "discuz") {
            column(name: "account_status", type: "integer") {
                constraints(nullable: "false")
            }
        }
    }


    changeSet(author: "zhiqiang.zhao (generated)", id: "init-website") {
        grailsChange {
            change {
                sql.execute("insert into discuz (`id`,`version`,username, `password`, url, login_type, send_type, account_status) VALUES('4','1','txws114','tt998aa11','http://bbs.exrpg.com',1,1,1)")
                sql.execute("insert into discuz (`id`,`version`,username, `password`, url, login_type, send_type, account_status) VALUES('5','1','txwszq','19881013asd','http://bbs.xs163.net',1,1,1)")
                sql.execute("insert into discuz (`id`,`version`,username, `password`, url, login_type, send_type, account_status) VALUES('7','1','txwszq','19881013asd','http://bbs.heze.cc',1,1,1)")
                sql.execute("insert into discuz (`id`,`version`,username, `password`, url, login_type, send_type, account_status) VALUES('8','1','txwszq','6e764438782bcb966bbede02812f9670','http://bbs.banma.com',1,1,1)")
                sql.execute("insert into discuz (`id`,`version`,username, `password`, url, login_type, send_type, account_status) VALUES('9','1','txwszq','19881013asd','http://bbs.ivocaloid.com',1,1,2)")
//                sql.execute("insert into discuz (`id`,`version`,username, `password`, url, login_type, send_type, account_status) VALUES('10','1','13771840053','19881013asd','http://bbs.66rpg.com',1,1,1)")
                sql.execute("insert into discuz (`id`,`version`,username, `password`, url, login_type, send_type, account_status) VALUES('11','1','txwszq','6e764438782bcb966bbede02812f9670','http://bbs.pcgta.cc',1,1,1)")
                sql.execute("insert into discuz (`id`,`version`,username, `password`, url, login_type, send_type, account_status) VALUES('12','1','txwszq','19881013asd','http://www.jianhucheng.com',1,1,1)")
            }
        }
    }
}
