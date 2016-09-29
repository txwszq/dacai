<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

</head>
<body>
<aside class="left-aside left-bg">
    <div>
        <ul class="left-ul">
            <li class="left-li "><i class="li-icon org-icon"></i><a class="active" href="../orgnization/orgnizationList.gsp"> 接入记录</a></li>
            <div class="ribbon hide">
                <i class="ribbon-left ribbonl"></i>
                <i class="ribbon-right ribbonr"></i>
            </div>
            <li class="left-li active "><i class="li-icon certify-icon"></i><a href="../certification/certificationRecord.html">认证记录 </a></li>
            <div class="ribbon ">
                <i class="ribbon-left ribbonl"></i>
                <i class="ribbon-right ribbonr"></i>
            </div>
            <li class="left-li"><i class="li-icon access-icon"></i><a href="../access/accessList.gsp">访问记录</a></li>
            <div class="ribbon hide">
                <i class="ribbon-left ribbonl"></i>
                <i class="ribbon-right ribbonr"></i>
            </div>
            <li class="left-li "><i class="li-icon operate-icon"></i><a href="../operation/operationRecord.gsp">操作记录</a></li>
            <div class="ribbon hide">
                <i class="ribbon-left ribbonl"></i>
                <i class="ribbon-right ribbonr"></i>
            </div>
            <li class="left-li"><i class="li-icon account-icon"></i><a href="../account/accountList.gsp"> 账号记录</a></li>
            <div class="ribbon hide">
                <i class="ribbon-left ribbonl"></i>
                <i class="ribbon-right ribbonr"></i>
            </div>
        </ul>
    </div>
</aside>
<section class="main">
    <div class="main-content ">
        <div class="panel">
            <div class="row">
                <div class="form-group">
                    <div class="col-md-3">
                        <label class="col-md-4 control-label">账号名称：</label>
                        <div class="col-md-8">
                            <input class="form-control" placeholder="请输入机构名称" name="orgName" required="required" />
                        </div>
                    </div>

                    <div class="col-md-5">
                        <label class="col-md-2 control-label">认证时间：</label>
                        <div class="begin">
                            <div class="col-md-1 begin-span">从</div>
                            <div class="col-md-4">
                                <div class="input-group date from_date " data-date="" data-date-format=" yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                    <input class="form-control" size="16" type="text" value=""  name="begin-date"/>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="dtp_input2" value="" /><br/>
                            </div>
                        </div>
                        <div class="end">
                            <div class="col-md-1 end-span">到</div>
                            <div class="col-md-4">
                                <div class="input-group date end_date " data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input3" data-link-format="yyyy-mm-dd">
                                    <input class="form-control" size="16" type="text" value=""  name="end-date"/>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="dtp_input3" value="" /><br/>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-2">
                        <label class="col-md-6 control-label">认证结果：</label>
                        <div class="col-md-6">
                            <select class="form-control" name="bindable">
                                <option  value="2">全部</option>
                                <option  value="1">通过</option>
                                <option  value="0">不通过</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-2">
                        <button  class="btn btn-primary" onclick="searchOrg()">搜索</button>
                        <button  class="btn btn-primary">导出列表</button>
                    </div>

                </div>
            </div>
        </div>

        <div class="search-list">
            <div class="row">
                <div class="form-group">
                    <div class="col-md-3">
                        <label class="col-md-4 control-label">搜索结果：</label>
                        <div class="col-md-8">
                            <label class=" control-label"> 共<span>XX#</span>条记录</label>
                        </div>
                    </div>

                    <div class="bread  j_bread col-md-10 hide">
                    </div>
                </div>
            </div>
            <div class="row panel">
                <div class="list-div">
                    <table class="table table-responsive table-hover table-striped">
                        <thead>
                        <tr>
                            <td>序号</td>
                            <td>设备编号</td>
                            <td>机构名称</td>
                            <td>令牌</td>
                            <td>认证时间</td>
                            <td>设备指纹</td>
                            <td>认证结果</td>
                            <td>备注</td>

                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>007</td>
                            <td>工商银行</td>
                            <td>1</td>
                            <td>2016/7/26 00:06:30</td>
                            <td>11111-111111111111-11111111</td>
                            <td>通过</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>007</td>
                            <td>工商银行</td>
                            <td>1</td>
                            <td>2016/7/26 00:06:30</td>
                            <td>156+62</td>
                            <td>不通过</td>
                            <td>令牌过期</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>007</td>
                            <td>工商银行</td>
                            <td>1</td>
                            <td>2016/7/26 00:06:30</td>
                            <td>156+62</td>
                            <td>不通过</td>
                            <td>机构未接入</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>



    </div>
</section>
</body>
</html>
