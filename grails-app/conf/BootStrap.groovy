import com.learninggrails.SecRole
import com.learninggrails.SecUser
import com.learninggrails.SecUserSecRole

class BootStrap {

    def init = { servletContext ->

        // Roles
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(
                authority: 'ROLE_ADMIN').save(failOnError: true)
        def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(
                authority: 'ROLE_USER').save(failOnError: true)

        // Users
        def user1 = SecUser.findByUsername('cavneb') ?: new SecUser(
                username: 'cavneb',
                email: 'cavneb@gmail.com',
                enabled: true,
                password: 'password').save(failOnError: true)
        if (!user1.authorities.contains(userRole)) {
            SecUserSecRole.create user1, userRole, true
        }
        def user2 = SecUser.findByUsername('admin') ?: new SecUser(
                username: 'admin',
                email: 'admin@gmail.com',
                enabled: true,
                password: 'password').save(failOnError: true)
        [userRole, adminRole].each { role ->
            if (!user2.authorities.contains(role)) {
                SecUserSecRole.create user2, role, true
            }
        }

        // Assertions
        assert SecUser.count() == 2
        assert SecRole.count() == 2
        assert SecUserSecRole.count() == 3
    }

    def destroy = {
    }
}
