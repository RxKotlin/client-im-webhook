var express = require('express');
var app = express();
var bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.use(function (req, res) {
  var post_data = req.body;
  console.log(post_data);
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});

app.listen(3001, function () {
  console.log('Example app listening on port 3001!');
});

