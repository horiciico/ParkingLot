<%@tag description="base page template" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle" required="true" rtexprvalue="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>${pageTitle}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="d-flex flex-column min-vh-100">

  <!-- Meniu sus -->
  <jsp:include page="/WEB-INF/pages/menu.jsp" />

  <!-- Aici se injectează DOAR conținutul din pagini -->
  <main class="container mt-5 pt-4 flex-grow-1">
    <jsp:doBody/>
  </main>

  <!-- UN SINGUR Footer jos de tot -->
  <footer class="container my-4 pt-3 border-top">
    <p class="float-end"><a href="#">Back to top</a></p>
    <p>&copy; 2017–2026 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
  </footer>

</body>
</html>