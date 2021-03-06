'use strict';

angular.module('jobvacancyApp')
    .factory('JobOffer', function ($resource, DateUtils) {
        return $resource('api/jobOffers/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    console.log("Log: " + JSON.stringify(data));
                    data.expirationDate =  DateUtils.convertLocaleDateFromServer(data.expirationDate);
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    })
    .factory('Offer', function ($resource, DateUtils) {
        return $resource('api/offers/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
        });
    });
