const keyInput = document.getElementById('licenseKey');
const statusText = document.getElementById('status');
const activateBtn = document.getElementById('activateBtn');

function goTo(id) {
  document.getElementById(id)?.scrollIntoView({behavior:'smooth'});
}

activateBtn.addEventListener('click', () => {
  const key = keyInput.value.trim();

  if (!key) {
    statusText.textContent = 'Please enter your activation key.';
    keyInput.focus();
    return;
  }

  statusText.textContent =
    'Activation server is not connected yet. No license has been activated.';
});

document.getElementById('playBtn').addEventListener('click', () => {
  statusText.textContent =
    'Client installation and verified activation are required first.';
});
