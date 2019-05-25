class LoginPresenter {

    onLogin() {
        window.location.assign("#/student-list");
    }

}

const loginPresenter = new LoginPresenter();

export default loginPresenter;