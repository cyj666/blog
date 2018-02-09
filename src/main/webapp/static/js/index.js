/**
 * 
 */
$(function() {
		$(".notice").load("/notice"/*,"",function(responseTxt,statusTxt,xhr){
				    if(statusTxt=="success")
				        alert("外部内容加载成功！");
				      if(statusTxt=="error")
				        alert("Error: "+xhr.status+": "+xhr.statusText);
				    }*/)
	});
$(function() {
		$(".showbook").load("/getBookRandom",function(responseTxt,statusTxt,xhr){
			/**
			*load()方法返回的是字符串，不是json数据，所以要进行字符串转json
			*
			*/		
			var userId = $(".userId").text();
			var json = JSON.parse(responseTxt);
			$(".test").html('<h5 class="text-warning suibian">随便看看</h5>'
					+'<a href="book?userId='+userId+'&bookId='+json[0].bookId+'&bookName='+json[0].bookName+'&bookAuthor='+json[0].bookAuthor+'"><img src="/pic?picUrl=/book/'+json[0].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<a href="book?userId='+userId+'&bookId='+json[1].bookId+'&bookName='+json[1].bookName+'&bookAuthor='+json[1].bookAuthor+'"><img src="/pic?picUrl=/book/'+json[1].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<a href="book?userId='+userId+'&bookId='+json[2].bookId+'&bookName='+json[2].bookName+'&bookAuthor='+json[2].bookAuthor+'"><img src="/pic?picUrl=/book/'+json[2].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<a href="book?userId='+userId+'&bookId='+json[3].bookId+'&bookName='+json[3].bookName+'&bookAuthor='+json[3].bookAuthor+'"><img src="/pic?picUrl=/book/'+json[3].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<a href="book?userId='+userId+'&bookId='+json[4].bookId+'&bookName='+json[4].bookName+'&bookAuthor='+json[4].bookAuthor+'"><img src="/pic?picUrl=/book/'+json[4].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[0].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[1].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[2].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[3].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[4].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[0].bookAuthor+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[1].bookAuthor+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[2].bookAuthor+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[3].bookAuthor+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[4].bookAuthor+'</small>'
					+'<a href="book?userId='+userId+'&bookId='+json[5].bookId+'&bookName='+json[5].bookName+'&bookAuthor='+json[5].bookAuthor+'"><img src="/pic?picUrl=/book/'+json[5].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<a href="book?userId='+userId+'&bookId='+json[6].bookId+'&bookName='+json[6].bookName+'&bookAuthor='+json[6].bookAuthor+'"><img src="/pic?picUrl=/book/'+json[6].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<a href="book?userId='+userId+'&bookId='+json[7].bookId+'&bookName='+json[7].bookName+'&bookAuthor='+json[7].bookAuthor+'"><img src="/pic?picUrl=/book/'+json[7].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<a href="book?userId='+userId+'&bookId='+json[8].bookId+'&bookName='+json[8].bookName+'&bookAuthor='+json[8].bookAuthor+'""><img src="/pic?picUrl=/book/'+json[8].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<a href="book?userId='+userId+'&bookId='+json[9].bookId+'&bookName='+json[9].bookName+'&bookAuthor='+json[9].bookAuthor+'"><img src="/pic?picUrl=/book/'+json[9].bookName+'.jpg" width="114px" height="160px" style="margin:10px;"></a>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[5].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[6].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[7].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[8].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[9].bookName+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[5].bookAuthor+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[6].bookAuthor+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[7].bookAuthor+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[8].bookAuthor+'</small>'
					+'<small class="text-center" style="display:inline-block;width:114px;margin-left:10px;margin-right:10px">'+json[9].bookAuthor+'</small>');
		});
		
	});

