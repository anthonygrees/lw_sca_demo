// Cross-Site Request Forgery (CSRF): CSRF is a vulnerability where an attacker can execute an action on behalf of a user without their knowledge or consent by tricking them into clicking a link or submitting a form. This vulnerability can be mitigated by using CSRF tokens to ensure that requests originate from the intended user.
<form action="/change-password" method="POST">
  <input type="password" name="new-password">
  <input type="submit" value="Change Password">
</form>
