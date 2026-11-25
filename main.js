const { app, BrowserWindow } = require('electron');

app.whenReady().then(() => {
  const win = new BrowserWindow({
    width: 1200,
    height: 760,
    backgroundColor: '#090711',
    autoHideMenuBar: true
  });
  win.loadFile('index.html');
});
