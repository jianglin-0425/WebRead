configure({
  configs: [
    './prod.js'
  ],
  sources: [
    source('amd', 'ephox/tinymce', '', mapper.constant('back/back/back/back/back/tinymce')),
    source('amd', 'ephox.mcagar', 'back/back/lib/test', mapper.flat),
    source('amd', 'ephox', 'back/back/lib/test', mapper.flat)
  ]
});
