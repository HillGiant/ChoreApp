var app = angular.module('choresapp', []);

app.controller('chorescontroller', function($scope, $http) {
  $http.get('http://localhost:8080/choretracker/rest/hello')
       .then(function(res){
          $scope.items = res.data;                
    });

  /*this.sometext = 'Colleen';
  this.items = {GetAllCustomersResult:[
  {"title":"Kiss Matt", "dueBy":new Date("10/13/15")},
  {"title":"Cuddle Pixel", "dueBy":new Date("03/14/16")},
  {"title":"Feed the cats", "dueBy":new Date("11/11/15")}]};*/
});