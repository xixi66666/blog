var data = {
	title: "", //标题
	select: "", //分类value
	text: "" //文本区
}
$(function() {

	$.ajax({
		async: false,
		url: "/loadAllTags",
		success: function (result) {
			let select = document.getElementById("select");
			for (let i = 0; i < result.length; i++) {
				let option = document.createElement("option");
				option.value = result[i].name;
				option.innerText = result[i].name;
				select.appendChild(option);
			}
		}
	})

	let search = window.location.search;
	if (search != "") {//如果地址栏博客ID不为空，则从草稿箱来，进行内容预加载
		let blogID = search.substring(search.indexOf("=") + 1);
		$.ajax({
			url: "/findBlogContentByID/" + blogID,
			success: function (result) {
				let title = document.getElementById("title");
				title.value = result.title;
				editor.txt.append(result.description)
				let options = document.getElementById("select").children;
				for (let i = 0; i < options.length; i++) {
					if (options[i].value == result.tag)
						options[i].selected = true;
				}
				data.title = result.title;
				data.select = result.tag;
				data.text = editor.txt;
			}
		})
	}

	//提交点击
	$("#btnSubmit").click(function() {
		// console.log(data);
		let search = window.location.search;
		if (search != "") {//这里说明是从草稿箱来的
			let blogID = search.substring(search.indexOf("=") + 1);
			$.ajax({
				url: "/updateBlogFromDraftToFormal/" + blogID,
				type: "POST",
				data: {
					"data": data
				},
				success: function (result) {
					editor.txt.append('')
					alert("博客发布成功！")
					window.location.href = "./"
				}
			})
		} else {
			$.ajax({
				url: "/handOnBlog",
				type: "POST",
				data:{
					"data" : data
				},
				success:function (result) {
					editor.txt.append('')
					alert("博客发布成功！")
					window.location.href = "./"
				}
			})
		}
	});

	$("#btnSave").click(function () {
		let search = window.location.search;
		if (search != "") {//这里说明是从草稿箱来的,依然点击保存按钮，此时要进行的是从草稿箱到草稿箱
			let blogID = search.substring(search.indexOf("=") + 1);
			$.ajax({
				url: "/updateBlogFromDraftToDraft/" + blogID,
				type: "POST",
				data: {
					"data": data
				},
				success: function (result) {
					editor.txt.append('')
					alert("草稿保存成功！")
					window.location.href = "./"
				}
			})
		} else {
			$.ajax({
				url: "/saveToDraft",
				type: "POST",
				data: {
					"data": data
				},
				success: function (result) {
					editor.txt.append('')
					alert("草稿保存成功！")
					window.location.href = "./"
				}
			})
		}
	})

	//标题框监控
	$("#title").blur(function() {
		data.title = $(this).val();
	});

	//选择框监控
	$("#select").change(function() {
		data.select = $(this).val();
	});

	var editor = new wangEditor('#text'); //创建富文本对象
	editor.config.width = "100%"; //设置编辑区域高度
	editor.config.height = 350; //设置编辑区域高度
	editor.config.onchange = function(html) {
		data.text = html;
	}

	// 配置 server（图片上传） 接口地址
	editor.config.uploadImgServer = '/blogEditor';
	//上传参数（自定义）
	editor.config.uploadImgParams = {
		name: "张三" //例
	};
	//上传图片名称
	editor.config.uploadFileName = 'file';

	editor.config.uploadImgHooks = {
		// 上传图片出错，一般为 http 请求的错误
		error: function(xhr, editor, resData) {
			console.log('error', xhr, resData)
		},
		// 上传图片超时
		timeout: function(xhr) {
			console.log('timeout')
		},
		// 上传结果
		customInsert: function(insertImgFn, result) {
			// insertImgFn 可把图片插入到编辑器，传入图片 src ，执行函数即可
			insertImgFn(result.data.url);
		}
	}

	editor.config.uploadVideoServer = '/videoUpload';
	editor.config.uploadVideoName = 'file';

	editor.create(); //执行 create()



});
