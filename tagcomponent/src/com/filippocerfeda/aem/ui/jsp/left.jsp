<%@include file="/apps/mysite/components/shared/global.jsp"%>
<%
%><mtg:component var="leftNav" logic="com.filippocerfeda.aem.ui.mycomponents.LeftNavigation">
	<nav class="section-menu  ${leftNav.collapsible ? 'expandable':''}">
		<ul>
		  <li>
          <c:if test="${null ne leftNav.rootPage}"> 
		      <h2>
		          <a href="">rootPage</a>
		      </h2>
	          <div class="section-menu-sub-menu">
	              <div class="section-menu-sub-menu-inner">
	                  <div class="section-menu-categories">
	                      <c:forEach var="itemlevel2" items="${leftNav.rootChildren}">
	                          <div class="section-menu-category">
	                          .......
	                          </div>
	                      </c:forEach>
	                  </div>
	              </div>
	          </div>
          </c:if>                          
          </li>
        </ul>
	</nav>
</mtg:component>