<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Negociações">
	<jsp:attribute name="extraStyles"></jsp:attribute>
	<jsp:attribute name="extraScripts"></jsp:attribute>

	<jsp:body>
		<form method="post" action="<c:url value='/negociacoes' />">
			<div class="form-group">
				<label for="data">Data</label>
				<input id="data" name="data" class="form-control" required="required">
			</div>
			
			<div class="form-group">
				<label for="quantidade">Quantidade</label>
				<input id="quantidade" name="quantidade" type="number" class="form-control" required="required">
			</div>
			
			<div class="form-group">
				<label for="valor">Valor</label>
				<input id="valor" name="valor" class="form-control" required="required">
			</div>
			
			<input type="submit" value="Adicionar" class="btn btn-primary">
		</form>
		
		<div class="table-responsive">
			<table class="table table-stripped table-hover">
				<thead>
					<tr>
						<th>DATA</th>
						<th>QUANTIDADE</th>
						<th>VALOR</th>
						<th>VOLUME</th>
						<th>DIAS CORRIDOS</th>
						<th>REMOVER</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${negociacoes}" var="negociacao">
						<tr>
							<td>
								<fmt:formatDate value="${negociacao.data.time}" pattern="dd/MM/yyyy" />
							</td>
							
							<td>
								<c:out value="${negociacao.quantidade}" />
							</td>
							
							<td>
								<fmt:formatNumber type="currency" value="${negociacao.valor}" />
							</td>
							
							<td>
								<fmt:formatNumber type="currency" value="${negociacao.volume()}" />
							</td>
							
							<td>
								<c:out value="${negociacao.diasCorridos()}" />
							</td>
							
							<td>
								<form method="post" action="<c:url value='/negociacoes/${negociacao.id}' />">
									<input type="hidden" name="_method" value="DELETE">
									<input type="hidden" name="id" value="${negociacao.id}">
									
									<button type="submit" class="btn btn-danger">
										<span class="glyphicon glyphicon-trash"></span> Remover
									</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</jsp:body>
</custom:template>
