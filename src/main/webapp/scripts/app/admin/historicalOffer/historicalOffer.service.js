'use strict';

angular.module('jobvacancyApp')
    .factory('historicalOfferService', function ($resource) {
        return $resource('api/totalOffers', {}, {
            'get': { method: 'GET', isArray: false}
        });
    }); 
