configure({
  configs: [
    './prod.js'
  ],
  sources: [
    source('amd', 'tinymce/inlite/Demo', 'back/back/src/demo/js', mapper.hierarchical)
  ]
});
