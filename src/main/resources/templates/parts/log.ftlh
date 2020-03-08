<#macro login path isRegisterform>
<form action="${path}" method="post" xmlns="http://www.w3.org/1999/html">
    <div class="form-group">
        <label class="col-sm-2 col-form-label"> User Name :</label>
        <div class="col-sm-10">
            <input type="text" name="username" class="form-control" placeholder="username"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 col-form-label"> Password: </label>
        <div class="col-sm-10">
            <input type="password" name="password" class="form-control" placeholder="password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <#if isRegisterform>
    <a href="/registration">Add new user</a>
    </#if>
    <button type="submit" class="btn btn-primary"><#if isRegisterform>Sign in<#else>Create</#if></button>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary">Sign out</button>
</form>
</#macro>