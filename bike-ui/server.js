// Get dependencies
const express = require('express');
const http = require('http');
const bodyParser = require('body-parser');
const proxy = require('express-http-proxy');
const cors = require('cors');
const _app_folder = 'dist/bike-ui';


const app = express();

// Parsers for POST data
app.use(bodyParser.json({limit: '20mb'}));
app.use(bodyParser.urlencoded({ extended: false, limit: '20mb' }));

app.use(cors());

// Point static path to dist
app.use(express.static(_app_folder));

// Set our api routes proxy to point to spring boot server
app.use('/server', proxy('http://localhost:8080'));


// Catch all other routes and return the index file
app.all('*', function (req, res) {
    res.status(200).sendFile(`/`, {root: _app_folder});
});

/**
 * Get port from environment and store in Express.
 */
 const port = '4201';
app.set('port', port);

/**
 * Create HTTP server.
 */
const server = http.createServer(app);

/**
 * Listen on provided port, on all network interfaces.
 */
server.listen(port, () => console.log(`API running on ${port}`));