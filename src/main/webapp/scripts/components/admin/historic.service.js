'use strict';

angular.module('jobvacancyApp')
    .factory('historicService', function ($resource) {
        return $resource('api/totalOffers', {}, {
            'get': { method: 'GET'}
        });
    }); 
