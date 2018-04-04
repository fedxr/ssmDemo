var main = {
    basePath: '',

    //tabs切换
    active: function() {
        $('#tabs').on('click','li', function(){
            var self = $(this);
            self.addClass('ac').siblings().removeClass('ac'); //tabs激活
            var name = self.attr('data-name');
            $('#'+name+'_form').addClass('show').siblings().removeClass('show'); //搜索页切换
        });
    },

    bind: function () {
        var _this = this;
        $('#all').on('click',function () {
            _this.getNotes(0);
        });
        $('#ind').on('click',function () {
            var userId = $('#userId').val();
            _this.getNotes(userId);
        });

        //显示收起添加框
        $('#add').on('click', function () {
            $(this).hide();
            $('#submit, #cancel').show();
            $('.new-note .work-note').slideDown();
        });
        $('#submit').on('click', function () {
            _this.addNote();

        });
        $('#cancel').on('click', function () {
            $(this).hide();
            $('#submit').hide();
            $('#add').show();
            $('.new-note .work-note').slideUp();
        });
    },

    // 登录注册页切换
    toggleSignInUp: function() {
        // 显示注册页
        $('#signup').on('click', function() {
            $('#signinForm').hide();
            $('#signupForm').show();
            $('#name').animate({height:'55px'},'200ms');
        });
        // 显示登录页
        $('#signin').on('click', function() {
            $('#name').animate({height:'0px'},'200ms', function() {
                $('#signupForm').hide();
                $('#signinForm').show();
            });
        });
    },

    //注册表单验证
    validate: function() {
        $('#signupForm').validate({
			rules: {
				account: {
					required: true,
					minlength: 2
                },
                username: {
					required: true,
					minlength: 2
				},
				password: {
					required: true,
					minlength: 4
				}
			},
			messages: {
				account: {
					required: "此处不可为空",
					minlength: "长度不可短于2个字符"
                },
                username: {
					required: "此处不可为空",
					minlength: "长度不可短于2个字符"
				},
				password: {
					required: "密码不可为空",
					minlength: "长度不可短于4个字符"
				}
			}
		});
    },

    //请求记录
    getNotes: function (userId) {
        var _this = this;

        if (userId === 0) {
            $('.new-note').hide();
        } else {
            $('.new-note').show();
        }

        $.ajax({
            url: this.basePath + '/note/showNote.do?userId=' + userId,
            type: 'POST',
            contentType: 'application/json;charset=utf-8',
            async: true, //或false,是否异步
            dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
            success: function (data, textStatus, jqXHR) {
                _this.buildNotes(data, userId);
            },
            error: function (xhr, textStatus) {
                alert('请求失败');
            }
        });
    },

    //添加新记录
    addNote: function () {
        var _this = this;
        var userName = $('#userName').val();
        var userId = $('#userId').val();
        var job = $('#job').val();
        var newJob = $('#newJob').val();
        var weekCount = _this.getYearWeek();
        var regDate = _this.getDate();

        var json = {
            userName: userName,
            userId: userId,
            job: job,
            newJob: newJob,
            weekCount: weekCount,
            regDate: regDate
        };

        $.ajax({
            url: this.basePath + '/note/submitNote.action',
            type: 'POST',
            data: JSON.stringify(json),
            contentType: 'application/json;charset=utf-8',
            async: true, //或false,是否异步
            dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
            success: function (data, textStatus, jqXHR) {
                $('#submit, #cancel').hide();
                $('#add').show();
                $('.new-note .work-note').slideUp();
                console.log(data);
                _this.getNotes(userId);
            },
            error: function (xhr, textStatus) {
                alert('请求失败');
            }
        });
    },

    deleteNote: function (id) {
        var _this = this;
        var r=confirm("确认删除？")
        if (r==true) {
            var userId = $('#userId').val();
            $.ajax({
                url: this.basePath + '/note/deleteNote.json',
                type: 'POST',
                data: JSON.stringify({'id':id}),
                contentType: 'application/json;charset=utf-8',
                async: true, //或false,是否异步
                dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
                success: function (data, textStatus, jqXHR) {
                    _this.getNotes(userId);
                    alert('删除成功');
                },
                error: function (xhr, textStatus) {
                    alert('请求失败');
                }
            });
        }
    },

    //拼接note的dom
    buildNotes: function (data, userId) {
        var _this= this;
        var dom = $('<div></div>');
        for (var i = 0, length = data.length; i < length; i++) {
            var div = $('<div class="work-note"></div>');
            var info = $('<div class="inline-t info"></div>');
            var note = $('<div class="inline-t note"></div>');
            if (userId == 0) {
                info.html('<p>'+data[i].userName+'</p><p>第'+data[i].weekCount+'周</p><p>'+data[i].regDate+'</p>');
            } else {
                info.html('<p>'+data[i].userName+'</p><p>第'+data[i].weekCount+'周</p><p>'+data[i].regDate+'</p><a href="javascript:main.deleteNote ('+data[i].id+')">删除</a>');
            }
            note.html('<b>本周计划：</b><p>'+data[i].newJob+'</p><hr><b>上周工作：</b><p>'+data[i].job+'</p>');
            div.append(info).append(note);
            dom.append(div);
        }
        _this.insert(dom);
    },

    //插入到container中
    insert: function (dom) {
        $('#catPad').empty();
        $('#catPad').append(dom);
    },

    //截取url地址
    getBasePath: function () {
        var localObj = window.location;
        var contextPath = localObj.pathname.split("/")[1];
        this.basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;
    },

    //判断第几周
    getYearWeek: function () {
        var t = new Date();
        var y = t.getFullYear();
        var m = t.getMonth();
        var d = t.getDate();
        var date1 = new Date(y, m, d),
            date2 = new Date(y, 0, 1),
            c = Math.round((date1.valueOf() - date2.valueOf()) / 86400000);
        return Math.ceil((c + ((date2.getDay() + 1) - 1)) / 7);
    },

    //获取当前时间设置为YY-MM-DD格式
    getDate: function () {
        var t = new Date();
        var y = t.getFullYear();
        var m = t.getMonth() + 1;
        var d = t.getDate();
        return y+'-'+m+'-'+d;
    }
};

$(function() {
    main.active();
    main.validate();
    main.toggleSignInUp();
    main.getBasePath();
    main.getNotes(0);
    main.bind();
});