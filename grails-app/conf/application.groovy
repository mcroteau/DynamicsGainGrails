grails.controllers.upload.maxFileSize=500000000
grails.controllers.upload.maxRequestSize=500000000

/** Spring Security Shiro plugin **/
grails.plugin.springsecurity.shiro.active                      = true
grails.plugin.springsecurity.logout.postOnly                   = false
grails.plugin.springsecurity.userLookup.userDomainClassName    = 'io.vanilla.Account'
grails.plugin.springsecurity.authority.className               = 'io.vanilla.Role'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'io.vanilla.AccountRole'
grails.plugin.springsecurity.shiro.permissionDomainClassName   = 'io.vanilla.Permission'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/notFound',       access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/uploads/**',     access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/fonts/**',    access: ['permitAll']],
	[pattern: '/**/documents/**', access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/fonts',       filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]