<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - Healthcare Management System</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/resources/css/about.css' />">
</head>
<body class="bg-gray-50">
    <!-- Hero Section -->
    <div class="medical-pattern bg-gradient-to-br from-blue-50 to-white">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-20">
            <div class="text-center mb-16">
                <div class="inline-block p-2 px-6 bg-blue-50 rounded-full text-blue-600 font-semibold mb-6">
                    College Healthcare Innovation
                </div>
                <h1 class="text-5xl font-bold gradient-text mb-6">
                    Transforming Student Healthcare
                </h1>
                <p class="text-xl text-gray-600 max-w-3xl mx-auto leading-relaxed">
                    Pioneering digital solutions for modern college healthcare management,
                    ensuring every student receives timely and efficient medical attention.
                </p>
            </div>
        </div>
    </div>

    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 -mt-12">
        <!-- Stats Cards -->
        <div class="grid md:grid-cols-3 gap-8 mb-16">
            <div class="bg-white rounded-2xl shadow-xl p-8 transform hover:-translate-y-1 transition-transform duration-300">
                <div class="flex items-center justify-between mb-4">
                    <div class="w-16 h-16 bg-blue-100 rounded-2xl flex items-center justify-center">
                        <svg class="w-8 h-8 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 14l-7 7m0 0l-7-7m7 7V3"></path>
                        </svg>
                    </div>
                    <span class="text-4xl font-bold text-blue-600">24/7</span>
                </div>
                <h3 class="text-xl font-bold text-gray-900 mb-2">Continuous Care</h3>
                <p class="text-gray-600">Round-the-clock monitoring and support for student health management.</p>
            </div>

            <div class="bg-white rounded-2xl shadow-xl p-8 transform hover:-translate-y-1 transition-transform duration-300">
                <div class="flex items-center justify-between mb-4">
                    <div class="w-16 h-16 bg-green-100 rounded-2xl flex items-center justify-center">
                        <svg class="w-8 h-8 text-green-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                        </svg>
                    </div>
                    <span class="text-4xl font-bold text-green-600">100%</span>
                </div>
                <h3 class="text-xl font-bold text-gray-900 mb-2">Digital Records</h3>
                <p class="text-gray-600">Complete digitization of health records for seamless access and management.</p>
            </div>

            <div class="bg-white rounded-2xl shadow-xl p-8 transform hover:-translate-y-1 transition-transform duration-300">
                <div class="flex items-center justify-between mb-4">
                    <div class="w-16 h-16 bg-purple-100 rounded-2xl flex items-center justify-center">
                        <svg class="w-8 h-8 text-purple-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z"></path>
                        </svg>
                    </div>
                    <span class="text-4xl font-bold text-purple-600">Fast</span>
                </div>
                <h3 class="text-xl font-bold text-gray-900 mb-2">Quick Response</h3>
                <p class="text-gray-600">Immediate attention to medical emergencies and health concerns.</p>
            </div>
        </div>

        <!-- Feature Section -->
        <div class="bg-white rounded-3xl shadow-xl overflow-hidden mb-16">
            <div class="p-8 md:p-12">
                <h2 class="text-3xl font-bold text-gray-900 mb-8">Innovative Healthcare Solutions</h2>
                <div class="grid md:grid-cols-2 gap-12">
                    <div class="space-y-6">
                        <div class="flex items-start space-x-4">
                            <div class="w-12 h-12 bg-blue-100 rounded-2xl flex items-center justify-center flex-shrink-0">
                                <svg class="w-6 h-6 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2"></path>
                                </svg>
                            </div>
                            <div>
                                <h3 class="text-xl font-semibold mb-2">Smart Bed Management</h3>
                                <p class="text-gray-600 leading-relaxed">Real-time tracking of bed availability and patient status for optimal resource allocation.</p>
                            </div>
                        </div>
                        <div class="flex items-start space-x-4">
                            <div class="w-12 h-12 bg-green-100 rounded-2xl flex items-center justify-center flex-shrink-0">
                                <svg class="w-6 h-6 text-green-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                                </svg>
                            </div>
                            <div>
                                <h3 class="text-xl font-semibold mb-2">Health Analytics</h3>
                                <p class="text-gray-600 leading-relaxed">Advanced analytics for tracking health trends and improving care delivery.</p>
                            </div>
                        </div>
                    </div>
                    <div class="space-y-6">
                        <div class="flex items-start space-x-4">
                            <div class="w-12 h-12 bg-purple-100 rounded-2xl flex items-center justify-center flex-shrink-0">
                                <svg class="w-6 h-6 text-purple-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                                </svg>
                            </div>
                            <div>
                                <h3 class="text-xl font-semibold mb-2">Digital Records</h3>
                                <p class="text-gray-600 leading-relaxed">Secure electronic health records for comprehensive patient history.</p>
                            </div>
                        </div>
                        <div class="flex items-start space-x-4">
                            <div class="w-12 h-12 bg-yellow-100 rounded-2xl flex items-center justify-center flex-shrink-0">
                                <svg class="w-6 h-6 text-yellow-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9"></path>
                                </svg>
                            </div>
                            <div>
                                <h3 class="text-xl font-semibold mb-2">Smart Notifications</h3>
                                <p class="text-gray-600 leading-relaxed">Automated alerts for medication schedules and important updates.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

		  <!-- Team Section -->
		<div class="bg-gradient-to-br from-blue-50 to-white rounded-3xl shadow-xl p-12 mb-16">
		    <h2 class="text-3xl font-bold text-center gradient-text mb-12">Meet Our Team</h2>
		    <div class="grid md:grid-cols-2 gap-12">
		        <!-- Team Member 1 -->
		        <div class="bg-white rounded-2xl p-8 shadow-lg transform hover:-translate-y-1 transition-transform duration-300">
		            <div class="text-center">
		                <div class="w-32 h-32 bg-gradient-to-br from-blue-100 to-blue-200 rounded-full mx-auto mb-6 flex items-center justify-center">
		                    <svg class="w-16 h-16 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
		                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"></path>
		                    </svg>
		                </div>
		                <h3 class="text-xl font-bold text-gray-900 mb-3">Srinivas</h3>
		                <div class="flex items-center justify-center space-x-2 text-sm text-gray-500 mt-4">
		                    <span class="px-3 py-1 bg-blue-50 rounded-full text-blue-600">Spring MVC</span>
		                    <span class="px-3 py-1 bg-indigo-50 rounded-full text-indigo-600">MySQL</span>
		                </div>
		            </div>
		        </div>
		
		        <!-- Team Member 2 -->
		        <div class="bg-white rounded-2xl p-8 shadow-lg transform hover:-translate-y-1 transition-transform duration-300">
		            <div class="text-center">
		                <div class="w-32 h-32 bg-gradient-to-br from-blue-100 to-blue-200 rounded-full mx-auto mb-6 flex items-center justify-center">
		                    <svg class="w-16 h-16 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
		                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"></path>
		                    </svg>
		                </div>
		                <h3 class="text-xl font-bold text-gray-900 mb-3">Dhruva</h3>
		                <div class="flex items-center justify-center space-x-2 text-sm text-gray-500 mt-4">
		                    <span class="px-3 py-1 bg-blue-50 rounded-full text-blue-600">Spring MVC</span>
		                    <span class="px-3 py-1 bg-indigo-50 rounded-full text-indigo-600">Front-End</span>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>

        <!-- Contact Section -->
        <div class="text-center mb-16">
            <div class="inline-block p-2 px-6 bg-blue-50 rounded-full text-blue-600 font-semibold mb-6">
                Get in Touch
            </div>
            <h2 class="text-3xl font-bold gradient-text mb-8">Have Questions?</h2>
            <a href="#" class="inline-block px-8 py-4 bg-gradient-to-r from-blue-600 to-blue-700 text-white font-semibold rounded-xl hover:from-blue-700 hover:to-blue-800 transition-colors duration-300 shadow-lg hover:shadow-xl transform hover:-translate-y-1">
                Contact Us
            </a>
        </div>
    </div>
</body>
</html>