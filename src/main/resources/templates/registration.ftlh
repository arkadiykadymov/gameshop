<#import "parts/common.ftlh" as c>
<#import "parts/log.ftlh" as l>

<@c.page>
Add new user
${message?ifExists}
<@l.login "/registration" false />
</@c.page>