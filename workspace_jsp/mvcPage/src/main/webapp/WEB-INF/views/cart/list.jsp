<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 장바구니 상품 주문 수량 변경
		$('.cart-modify').on('click', function() {
			let input_quantity = $(this).parent().find('input[name="order_quantity"]');
			if(input_quantity.val()=='') {
				alert('수량을 입력하세요!');
				input_quantity.focus();
				return;
			}
			
			if(input_quantity.val()<1) {
				alert('상품의 최소 수량은 1입니다.');
				input_quantity.val(input_quantity.attr('value'));
				return;
			}
			
			// ajax 처리
			$.ajax({
				url:'modifyCart.do',
				type:'post',
				data:{
					cart_num:$(this).attr('data-cartnum'),
					item_num:$(this).attr('data-itemnum'),
					order_quantity:input_quantity.val()
				},
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(param) {
					if(param.result=='logout') {
						alert('로그인 후 사용하세요!');
					}
					else if(param.result=='noSale') {
						alert('판매 중지되었습니다.');
						location.href = 'list.do'; // 화면 갱신
					}
					else if(param.result=='noQuantity') {
						alert('상품의 수량이 부족합니다.');
						location.href = 'list.do'; // 화면 갱신
					}
					else if(param.result=='success') {
						alert('담은 수량이 수정되었습니다.');
						location.href='list.do'; // 화면 갱신
					}
					else {
						alert('수정시 오류 발생!');
					}
				},
				error:function() {
					alert('네트워크 오류 발생!');
				}
			}); // end of ajax
		}); // end of on
		
		// 장바구니 상품 삭제
		$('.cart-delete').on('click', function() {
			$.ajax({
				url:'deleteCart.do',
				type:'post',
				data:{cart_num:$(this).attr('data-cartnum')},
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(param) {
					if(param.result=='logout') {
						alert('로그인 후 사용하세요!');
					}
					else if(param.result=='success') {
						alert('선택하신 상품을 삭제했습니다.');
						location.href = 'list.do'; // 화면 갱신
					}
					else {
						alert('삭제시 오류 발생!');
					}
				},
				error:function() {
					alert('네트워크 오류 발생!');
				}
			}); // end of ajax
		}); // end of on
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>장바구니</h2>
	<c:if test="${empty list}">
	<div class="result-display">
		장바구니에 담은 상품이 없습니다.
	</div>
	</c:if>
	<c:if test="${!empty list}">
	<form id="cart_order" method="post" action="${pageContext.request.contextPath}/order/orderForm.do">
		<table>
			<tr>
				<th>상품명</th>
				<th>수량</th>
				<th>상품 가격</th>
				<th>합계</th>
			</tr>
			<c:forEach var="cart" items="${list}">
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/item/detail.do?item_num=${cart.item_num}">
						<img src="${pageContext.request.contextPath}/upload/${cart.item.photo1}" width="80">
						${cartitem.name}
					</a>
				</td>
				<td class="align-center">
					<c:if test="${cart.item.status==1 or cart.item.quantity<cart.order_quantity}">[판매 중지]</c:if>
					<c:if test="${cart.item.status!=1 or cart.item.quantity>=cart.order_quantity}">
					<input type="number" name="order_quantity" value="${cart.order_quantity}" min="1" max="99999" class="quantity-width">
					<br>
					<input type="button" value="변경" class="cart-modify" data-cartnum="${cart.cart_num}" data-itemnum="${cart.item_num}">
					</c:if>
				</td>
				<td class="align-center"><fmt:formatNumber value="${cart.item.price}"/>원</td>
				<td class="align-center">
					<fmt:formatNumber value="${cart.sub_total}"/>원
					<br>
					<input type="button" value="삭제" class="cart-delete" data-cartnum="${cart.cart_num}">
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="3" class="align-right"><b>총 구매 금액</b></td>
				<td class="align-center"><fmt:formatNumber value="${all_total}"/>원</td>
			</tr>
		</table>
		<div class="align-center">
			<input type="submit" value="구매하기">
		</div>
	</form>
	</c:if>
</div>
</body>
</html>