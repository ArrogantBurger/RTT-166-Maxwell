var validCredentials = [
    { username: 'user', password: 'pass' },
    { username: 'admin', password: 'admin'}
];


// Used in login.html
function login() {
    const form = document.getElementById('login-form');
    const username = document.getElementById('username');
    const password = document.getElementById('password');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        for (let credential of validCredentials) {
          if (credential.username === username.value && credential.password === password.value) {
            //console.log('Successfully logged in as' + username.value);
            alert('Successfully logged in as ' + username.value);
            return;
          } 
        } //search unable to find matching credentials

        //console.log('Invalid username or password');
        alert('Invalid username or password');
        return;
      });
}

// Used in sign-up.html
// Note that sign-ups currently do not persist on page reloads, can resolve by committing changes to database
function signUp() {
    const signUpForm = document.getElementById('signup-form');
    const username = document.getElementById('email');
    const password = document.getElementById('password');
    const passwordRepeat = document.getElementById('password-repeat');

    signUpForm.addEventListener('submit', function(event) {
        event.preventDefault();

        for (let credential of validCredentials) {
            console.log(credential.username);
            console.log(username.value);

            if (credential.username === username.value) {
            alert('Username already taken. Please select a different username.');
            return;
          } 
        } //search unable to find matching credentials, unique and valid username


        if (password.value != passwordRepeat.value){
            alert('Passwords do not match. Please re-enter the same password twice.');
            return;
        }
        //console.log('Invalid username or password');
        let validCredential = {username: username.value, password: password.value};
        validCredentials.push(validCredential);


        alert('Valid username and password! New account created');
        return;
    });
}
