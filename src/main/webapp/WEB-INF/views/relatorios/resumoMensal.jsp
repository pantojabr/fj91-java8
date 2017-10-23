<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Negociações">
	<jsp:attribute name="extraStyles"></jsp:attribute>
	<jsp:attribute name="extraScripts"></jsp:attribute>

	<jsp:body>
		<h1 class="text-center">Resumo Mensal de Negociações</h1>
		
		<div class="table-responsive">
			<table class="table table-stripped table-hover">
				<thead>
					<tr>
						<th>MÊS</th>
						<th>QUANTIDADE TOTAL</th>
						<th>VOLUME TOTAL</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${resumos}" var="resumo">
						<tr>
							<td>
								<c:out value="${resumo.mesFormatado()}" />
							</td>
							
							<td>
								<c:out value="${resumo.quantidade}" />
							</td>
							
							<td>
								<fmt:formatNumber type="currency" value="${resumo.volume}" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</jsp:body>
</custom:template>
