<%--
  Created by IntelliJ IDEA.
  User: 佳
  Date: 2017/12/27
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../comm/easyuiBasic.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#scoreDataGrid").datagrid({
                url:'${pageContext.request.contextPath}/score/queryAll',
                method:'GET',
                rownumbers:true,
                pagination:true,
                striped:true,
                toolbar:[
                    {
                        text:'添加',
                        iconCls:'icon-add',
                        handler:function () {
                            alert("添加");
                        }
                    },
                    {
                        text:'删除',
                        iconCls:'icon-remove',
                        handler:function () {
                            alert("删除");
                        }
                    }
                ],
                columns:[[
                    {field:'ck',checkbox:true},
                    {field:'grade',title:'班级',formatter:function (value, row, index) {
                        return row.student4.grade4.gradeName;
                    }},
                    {field:'student4',title:'姓名',formatter:function (value, row, index) {
                        return value.studentName;
                    }},
                    {field:'course4',title:'课程',formatter:function (value, row, index) {
                        return value.courseName;
                    }},
                    {field:'score',title:'成绩'},
                    {field:'id',title:'操作列',formatter:function (value, row, index) {
                        var queryScoreById = "<button onclick='queryScoreById(" + value + ")'>详情</button>";
                        var updateScore = "<button onclick='updateScore(" + value + ")'>修改</button>";
                        var deleteScore = "<button onclick='deleteScore(" + value + ")'>删除</button>";
                        return queryScoreById + updateScore + deleteScore;
                    }}
                ]]
            })
            //获取班级信息
            $.get("${pageContext.request.contextPath}/student/queryGrade",function (grade) {
                var grade1 = $.parseJSON('{"id":-1,"gradeName":"--请选择--"}');
                grade.push(grade1);
                $("#queryGradeCombobox").combobox({
                    valueField: 'id',
                    textField: 'gradeName',
                    data:grade,
                    onLoadSuccess:function () {
                        $(this).combobox("select", -1);
                    },
                    onSelect:function (grade) {//为班级匹配对应的学生列表
                        var gradeId = grade.id;
                        $.get("${pageContext.request.contextPath}/student/queryStudentByGradeId",{"gradeId":gradeId},
                        function (student) {
                            var student1 = $.parseJSON('{"id":-1,"studentName":"--请选择--"}');
                            student.push(student1);
                            $("#queryStudentCombobx").combobox({
                                valueField:'id',
                                textField:'studentName',
                                data:student,
                                onLoadSuccess:function () {
                                    $(this).combobox("select", -1);
                                }
                            })
                        })
                        
                    }
                });
            })
            $("#queryScoreButton").click(function () {
                var gradeId = $("#queryGradeCombobox").val();
                var studentId = $("#queryStudentCombobx").val();
                $("#scoreDataGrid").datagrid('load', {
                    "gradeId": gradeId,
                    "studentId": studentId
                });
            })
        })
        function queryScoreById(id) {
            alert(id);
        }
        function updateScore(id) {
            alert(id);
        }
        function deleteScore(id) {
            alert(id);
        }
    </script>
</head>
<body>
    <div>
        <form>
            班级：<input id="queryGradeCombobox" name="gradeId"/>
            学生：<input id="queryStudentCombobx" name="studentId"/>
            <a href="#" id="queryScoreButton" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        </form>
    </div>
    <table id="scoreDataGrid"></table>
    <%--详情--%>
    <div class="easyui-window" id="queryScoreByIdWindow"
         style="top: 30%; left: 30%; width: 500px; height: 300px; padding:60px 120px;"
         title="成绩详情" closed="true">
        <form id="queryScoreByIdForm">
            <div>
                班级：<input class="easyui-textbox" id="queryGradeName"/>
            </div>
            <div>
                学生：<input class="easyui-textbox" id="queryStudentName"/>
            </div>
            <div>
                课程：<input class="easyui-textbox" id="queryCourseName"/>
            </div>
            <div>
                成绩：<input class="easyui-textbox" id="queryScore"/>
            </div>


        </form>
    </div>
</body>
</html>
