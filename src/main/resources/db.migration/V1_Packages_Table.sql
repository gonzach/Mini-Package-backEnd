DROP TABLE IF EXISTS `packages`;

CREATE TABLE `packages` (
    `id` int(100) NOT NULL,
    `packageNo` int(100),
    `clientName` varchar(255) DEFAULT NULL,
    `telephone` int(100) DEFAULT NULL,
    `status` varchar(255) DEFAULT NULL,
    `bookingTime` date DEFAULT NULL,
    `pickUpTime` date DEFAULT NULL,
    PRIMARY KEY (`id`)
);