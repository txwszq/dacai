package com.exception

/**
 * Created by zhiqiang.zhao on 2016/8/18.
 */
class InvalidOperateExcpetion extends RuntimeException{

    InvalidOperateExcpetion(){
        super()
    }

    InvalidOperateExcpetion(msg) {
        super(msg)
    }
}
