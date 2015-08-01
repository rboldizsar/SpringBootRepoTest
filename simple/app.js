var myApp = angular.module( 'myApp' , ['ngRoute', 'isteven-multi-select'])
    .controller('msController', [ '$scope' , function($scope){
        $scope.modernBrowsers = [
            { 
                name: 'Opera',
                id: 'op1',
                ticked: true    
            },
            { 
                name: 'Internet Explorer',  
                id: 'ie1',
                ticked: false   
            },
            { 
                name: 'Firefox',                
                id: 'ff1',
                ticked: true    
            },
            { 
                name: 'Safari',                 
                id: 'sf1',
                ticked: false   
            },
            { 
                name: 'Chrome',                 
                id: 'ch1',
                ticked: true    
            },    
            { 
                name: 'Opera',                  
                id: 'op2',
                ticked: false    
            },
            { 
                name: 'Internet Explorer',  
                id: 'ie2',
                ticked: false   
            },
            { 
                name: 'Firefox',                
                id: 'ff2',
                ticked: false    
            },
            { 
                name: 'Safari',                 
                id: 'sf2',
                ticked: false   
            },
            { 
                name: 'Chrome',                 
                id: 'ch2',
                ticked: false    
            }
        ];
    }]);