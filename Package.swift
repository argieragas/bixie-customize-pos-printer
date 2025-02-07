// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "BixieCustomizePosPrinter",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "BixieCustomizePosPrinter",
            targets: ["BixiePOSPrinterPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "BixiePOSPrinterPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/BixiePOSPrinterPlugin"),
        .testTarget(
            name: "BixiePOSPrinterPluginTests",
            dependencies: ["BixiePOSPrinterPlugin"],
            path: "ios/Tests/BixiePOSPrinterPluginTests")
    ]
)