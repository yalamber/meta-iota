# meta-iota

![meta-iota](https://github.com/bernardoaraujor/meta-iota/raw/master/meta-iota.png  "meta-iota")

[IOTA](https://www.iota.org/) is a revolutionary new transactional settlement and data transfer layer for the Internet of Things. It’s based on a new distributed ledger, the Tangle, which gets rid off the inefficiencies of current Blockchain designs and introduces a new way of reaching consensus in a decentralized peer-to-peer system. For the first time ever, through IOTA people can transfer money without any fees. This means that even infinitesimally small nanopayments can be made through IOTA.

IOTA is the missing puzzle piece for the Machine Economy to fully emerge and reach its desired potential. We envision IOTA to be the public, permissionless backbone for the **Internet of Things** (**IoT**) that enables true interoperability between all devices.

The [**Yocto Project**](https://www.yoctoproject.org/) is an open source collaboration project that helps developers create custom Linux-based systems regardless of the hardware architecture. Meanwhile, [**OpenEmbedded**](http://www.openembedded.org/wiki/Main_Page) is a build automation framework and cross-compile environment used to create Linux distributions for embedded devices.

Together, these projects provides a flexible set of tools and a space where embedded developers worldwide can share technologies, software stacks, configurations, and best practices that can be used to create tailored Linux images for embedded and IoT devices, or anywhere a customized Linux OS is needed. 

The **meta-iota** OpenEmbedded Layer aims to provide recipes for IOTA related programs, tools and libraries in order to support the IOTA Tangle Ledger on a large variety of embedded devices.
 
Any collaborations (issues, patches, pull requests, suggestions) are more than welcome: <bernardoaraujor@gmail.com>

---
## Dependencies

The meta-iota layer depends on:

	URI: git://git.openembedded.org/openembedded-core
	layers: meta
	branch: warrior, thud

	URI: git://git.openembedded.org/meta-openembedded
	layers: meta-oe
	branch: warrior, thud
	
---
## Tutorials

 - [IOTA cIRI on a BeagleBone Black with Yocto Project and OpenEmbedded](https://medium.com/@bernardoaraujor/iota-ciri-on-a-beaglebone-black-with-yocto-project-and-openembedded-6dd5b1379a60)

---
## Donations
If you find meta-iota useful, please consider making a donation:

 - **BTC**: 3NUDRd9hZV2Y8cm6J7u6qmdQVNoWhJrjen
 - **LTC**: LSpyeCjxY28z9VpYjoGJGE8QZLxUL7Rk6c
 - **ETH**: 0x6028475be0b1cf8a566bec7ff4b4f5d28406266e
 - **IOTA**:     SZOYDT9OGQXRIAVIRWXMRMQXI9QJYUU9LVSIXXDTLZTS9EEPJTRIVKNDIIXVXBINWNCOCXQUIYNIPFOFAMKG9PE9NA

---
## License

meta-iota is released under the [MIT License](https://github.com/bernardoaraujor/meta-iota/blob/master/COPYING.MIT).
