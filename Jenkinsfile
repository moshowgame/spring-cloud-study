{
	"pipeline": {
		"agent": {
			"type": "any"
		},
		"stages": [{
			"name": "start2build",
			"branches": [{
				"name": "default",
				"steps": [{
					"name": "echo",
					"arguments": [{
						"key": "message",
						"value": {
							"isLiteral": true,
							"value": "start to build"
						}
					}]
				}]
			}]
		}, {
			"name": "maven:build",
			"branches": [{
				"name": "default",
				"steps": [{
					"name": "sh",
					"arguments": [{
						"key": "script",
						"value": {
							"isLiteral": true,
							"value": "#进入子目录\ncd spring-cloud-study-empty\n#清理并构建\nmvn clean package"
						}
					}]
				}]
			}]
		}, {
			"name": "jar:run",
			"branches": [{
				"name": "default",
				"steps": [{
					"name": "sh",
					"arguments": [{
						"key": "script",
						"value": {
							"isLiteral": true,
							"value": "#结束后台进程\n/home/moshow/Development/Workspace/stop.sh\n#后台运行jar包\nnohup java -jar -server target/spring-cloud-study-empty-0.0.1-SNAPSHOT.jar"
						}
					}]
				}]
			}]
		}, {
			"name": "success",
			"branches": [{
				"name": "default",
				"steps": [{
					"name": "echo",
					"arguments": [{
						"key": "message",
						"value": {
							"isLiteral": true,
							"value": "build success"
						}
					}]
				}]
			}]
		}]
	}
}
